def call(String stageName){
  
  if ("${stageName}" == "Build")
     {
       sh "mvn clean package"
     }
  else if ("${stageName}" == "SonarQube Report")
     {
       sh "mvn clean sonar:sonar"
     }
  else if ("${stageName}" == "Upload Into Nexus")
     {
       sh "mvn clean deploy"
     }
  else if ("${stageName}" == "Deploy to Tomcat"}
     {
     deploy adapters: [tomcat9(credentialsId: 'tomcatcredentials', path: '', url: 'http://107.23.108.142:8080/')], contextPath: null, onFailure: false, war: 'target/*war'
     }
}
