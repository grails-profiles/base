description("Prints out the Grails application's dependencies") {
    usage "grails dependency-report [configuration]"
    argument name: "Configuration", description: "Which source set to report on (compile, test, etc)", required: false
}

def arguments = []
commandLine.systemProperties.each { key, value ->
    arguments << "-D${key}=$value".toString()
}

def command = ["dependencies"]
if (commandLine.remainingArgs.size() > 0) {
    command << "--configuration ${commandLine.remainingArgs[0]}"
}

gradle."${command.join(' ')}"(*arguments)