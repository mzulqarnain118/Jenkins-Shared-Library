#!/usr/bin/env groovy
package com.example
class Docker implements Serializable {
  def script
  Docker(script){
    this.script=script
  }
  def buildDokcerImage(String imageName) {  
                       script.echo 'Building the Docker Image...'
                script.withCredentials([script.usernamePassword(credentialsId: 'docker-hub-repo', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
                    script.sh "docker build -t $imageName ."
                    script.sh "echo $script.PASS | docker login -u $script.USER --password-stdin"
                    script.sh "docker push $imageName"
                }
    }
     def dockerLogin() {  
                       script.echo 'Login to Docker...'
                script.withCredentials([script.usernamePassword(credentialsId: 'docker-hub-repo', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
                    script.sh "echo $script.PASS | docker login -u $script.USER --password-stdin"
                }
    }

     def dockerPush(String imageName) {  
                       script.echo 'Pushing the Docker Image...'
                    script.sh "docker push $imageName"
    }
     def dockerBuildImage(String imageName) {  
                       script.echo 'Building the Docker Image...'
                    script.sh "docker build -t $imageName ."
    }

    def purposeOfThisClass(){
      script.echo 'implements Serializable: for saving state in case of pipeline paused or resumed and for keeping groovy logic in a centralized way so we can use reuseable code'
    }
}