pipeline {

  agent any

  stages {	

	stage('Maven Compile'){

		steps{

			echo 'Project compile stage'

			bat label: 'Compilation running', script: '''mvn compile'''

	       	}

	}

	

	stage('Unit Test') {

	   steps {

			echo 'Project Testing stage'


	       

       		}

   	}

	  

	/*stage('Publish Test Coverage Report') {

         steps {

           step([$class: 'JacocoPublisher', 

     		 execPattern: 'target/*.exec',

     		 classPattern: 'target/classes',

     		 sourcePattern: 'src/main/java',

     		 exclusionPattern: 'src/test*'

		])

            }

        }*/

	  

	stage('Jacoco Coverage Report') {

        steps{

            jacoco()

		}

	}

	  

	stage('SonarQube analysis') {
		steps{
    withSonarQubeEnv('SonarQube') {
      bat label: '', script: '''mvn clean package sonar:sonar \
		 -Dsonar.host.url=http://localhost:9000 \
 		-Dsonar.login=ff5c276939ab066fea300810e7006165c6243c7b'''
    } 
  }
}
  
stage("Quality Gate") {
            steps {
                timeout(time: 1, unit: 'HOURS') {
                    // Parameter indicates whether to set pipeline to UNSTABLE if Quality Gate fails
                    // true = set pipeline to UNSTABLE, false = don't
                    waitForQualityGate abortPipeline: true
                }
            }
        }
	stage('Maven Package'){

		steps{

			echo 'Project packaging stage'

			bat label: 'Project packaging', script: '''mvn package'''

		}

	} 		

    

  }

}
