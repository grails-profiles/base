description("Executes Groovy scripts in a Grails context") {
    usage "grails run-script"
    argument name: "Script Name(s)", description: "The paths of scripts relative to the project root"
}
try {

    def arguments = ["-Pargs=\"${commandLine.remainingArgs.join(' ')}\""]
    commandLine.systemProperties.each { key, value ->
        arguments << "-D${key}=$value".toString()
    }

    gradle."runScript"(*arguments)

} catch (Throwable e) {
    console.error "Failed to execute one or more scripts", e
    return false
}
