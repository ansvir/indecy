package org.itique.indecy.core.flow;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import groovy.lang.Script;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public abstract class IndecyContext extends Script {

    private Map<Object, Double> params;
    private File scriptFile;

    public IndecyContext(Map<Object, Double> params, File scriptFile) {
        this.params = params;
        this.scriptFile = scriptFile;
    }

    @Override
    public Object run() {
        Binding binding = this.getBinding();
        binding.setVariable("params", this.params);
        GroovyShell shell = new GroovyShell(binding);
        try {
            Script script = shell.parse(prepareScript(scriptFile));
            return script.run();
        } catch (IOException e) {
            throw new IllegalArgumentException("Cannot run script under " + scriptFile.getAbsolutePath() + ". Cause: " + e);
        }
    }

    private String prepareScript(File scriptFile) throws IOException {
        List<String> lines = Files.readAllLines(scriptFile.toPath());
        Integer declarationIndex = IntStream.range(0, lines.size()).boxed()
                .filter(index -> lines.get(index).contains("Flow.declare"))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("Script " + scriptFile + " does not con contain Flow declaration!"));
        lines.add(declarationIndex - 1, "def params = this.params");
        return String.join("\n", lines);
    }
}
