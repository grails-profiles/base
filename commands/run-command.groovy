description("Executes Grails commands") {
    usage "grails run-command"
    argument name: "Command Name", description: "The name of the command to be executed"
}
try {

    def arguments = ["-Pargs=\"${commandLine.remainingArgs.join(' ')}\""]
    commandLine.systemProperties.each { key, value ->
        arguments << "-D${key}=$value".toString()
    }

    gradle."runCommand"(*arguments)

} catch (Throwable e) {
    console.error "Failed to execute a command", e
    return false
}