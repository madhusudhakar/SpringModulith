import org.springframework.modulith.core.ApplicationModules
import org.springframework.modulith.core.Violations
import spock.lang.Specification
import com.example.shop.ShopApplication

class ModuleStructureSpec extends Specification {

    def "application modules should be free of violations"() {
        given: "an application with defined modules"
        ApplicationModules modules = ApplicationModules.of(ShopApplication.class)

        when: "the module structure is verified"
        def result = modules.verify()

        then: "no violations should be found"
        if (result instanceof Violations) {
            assert !result.hasViolations() : "Module structure violations found: \n" + result.toString()
        } else {
            assert !result.toString().toLowerCase().contains("violation") : "Module structure violations found: \n" + result.toString()
        }
    }
}