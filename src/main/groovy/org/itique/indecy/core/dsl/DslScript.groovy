package org.itique.indecy.core.dsl

import java.nio.file.Path

class DslScript extends Script {

    Map<String, Double> params
    File scriptFile

    DslScript(Map<String, Double> params, File file) {
        this.params = params
        this.scriptFile = file
    }

    @Override
    Object run() {
        Binding binding = new Binding()
        binding.setVariable("params", params)
        GroovyShell shell = new GroovyShell(binding)
        return (Cases) shell.evaluate(scriptFile)
    }

}
