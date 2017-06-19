@artifact.package@
import grails.testing.services.ServiceUnitTest
import spock.lang.Specification

class @artifact.name@ServiceSpec extends Specification implements ServiceUnitTest<@artifact.name@Service>{

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }
}
