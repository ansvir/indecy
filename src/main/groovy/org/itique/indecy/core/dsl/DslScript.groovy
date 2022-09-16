package org.itique.indecy.core.dsl

import org.itique.indecy.core.flow.Parameters

class DslScript extends Script {

    Parameters params
    File scriptFile

    DslScript(Parameters params, File file) {
        this.params = params
        this.scriptFile = file
    }

    @Override
    Object run() {
        Binding binding = new Binding()
        binding.setVariable("params", params.getParams())
        GroovyShell shell = new GroovyShell(binding)
        return (Cases) shell.evaluate(scriptFile)
    }

}
