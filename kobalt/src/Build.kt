import com.beust.kobalt.*
import com.beust.kobalt.plugin.packaging.*
import com.beust.kobalt.plugin.application.*
import com.beust.kobalt.plugin.kotlin.*
import sun.tools.jar.resources.jar

val p = project {
    name = "kotlin_rxexplorer"
    group = "com.example"
    artifactId = name
    version = "0.1"

    dependencies {
        compile("org.jetbrains.kotlin:kotlin-runtime:1.2.50")
        compile("org.jetbrains.kotlin:kotlin-stdlib:1.2.50")
        compile( "io.reactivex.rxjava2:rxjava:2.1.15" )
    }

    dependenciesTest {
        compile("org.testng:testng:6.11")
    }

    assemble {
        jar {
        }
    }

    application {
        mainClass = "com.example.MainKt"
    }
}
