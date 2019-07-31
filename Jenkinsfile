node {

stages{

  stage('Complie Stage') {
  steps{
		withMaven(maven : maven1){
		bat 'mvn clean complie'
		}
  
  }
  
  }
 stage('Testing Stage') {
  steps{
		withMaven(maven : maven1){
		bat 'mvn test'
		}
  }
  
  }

 stage('Deploye Stage') {
  steps{
		withMaven(maven : maven1){
		bat 'mvn deploy'
		}
  }
}
}
}