# AWS Cognito Set-up - Local

## Steps in AWS Console

1. Sign in to the AWS Cognito console in your browser.
2. Manage User Pools. 
3. Create a User Pool. I used the defaults.
4. Added an app client. Took the defaults... for now...


## Steps in the project code base

1. Add cognito.properties to the resources directory, and update with values for **_your_** pool and application. 
    Example cognito.properties:  

         client.secret=<your client secret>
         client.id=2g3ttfdvgqrjc29hqmtu7g15ha
         oauthURL=https://user-display-demo-1.auth.us-east-2.amazoncognito.com/oauth2/token
         loginURL=https://user-display-demo-1.auth.us-east-2.amazoncognito.com/login
         redirectURL=http://localhost:8080/week1userdisplayexercise_war/auth
         region=us-east-2
         poolId=us-east-2_XaRYHsmKB

2. Add all classes in the auth package
3. Add 3 dependencies to the pom.xml

        <!-- for parsing access token -->
        <dependency>
            <groupId>com.auth0</groupId>
            <artifactId>java-jwt</artifactId>
            <version>3.4.1</version>
        </dependency>
        <dependency>
            <groupId>org.json</groupId>
            <artifactId>json</artifactId>
            <version>20170516</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/commons-io/commons-io -->
        <dependency>
            <groupId>commons-io</groupId>
            <artifactId>commons-io</artifactId>
            <version>2.11.0</version>
        </dependency>

4. Write a class based on Login to trigger the hosted Cognito sign-up/log-in.
5. Write a class based on Auth to (ultimately) get user info from Cognito.

## Next steps

1. Get the code running and working. There are many log statements to help you troubleshoot along the way.
2. Review the TODOs and consider how you will incorporate those recommendations. 
3. Consider how to add the user to your own table. Example: a user logs in, and they are not in your user table, add them...
4. If your application needs different roles (admin, regular user, etc.), consider how to manage this. Perhaps a role column, roles table, and/or using groups in cognito.
5. Watch for upcoming information about deploying to AWS Elastic Beanstalk.

## Resources for local

[Verifying a JSON Web Token](https://docs.aws.amazon.com/cognito/latest/developerguide/amazon-cognito-user-pools-using-tokens-verifying-a-jwt.html)

[Resolving missing attributes in ID token](https://github.com/aws-amplify/amplify-js/issues/5740)

[Cognito Java AWS Workshop](http://sid343.reinvent-workshop.com)

[Cognito User Pool Authentication Flow](https://docs.aws.amazon.com/cognito/latest/developerguide/amazon-cognito-user-pools-authentication-flow.html#amazon-cognito-user-pools-server-side-authentication-flow)

[Java integration with Amazon Cognito Tutorial](https://gorillalogic.com/blog/java-integration-with-amazon-cognito/)

[Understanding Amazon Cognito user poool OAuth 2.0 Grants](https://aws.amazon.com/blogs/mobile/understanding-amazon-cognito-user-pool-oauth-2-0-grants/)

## Resources for elastic beanstalk deploy

[Terminating Https on EC2 instances running Tomcat](https://docs.aws.amazon.com/elasticbeanstalk/latest/dg/https-singleinstance-tomcat.html)

[Create a certificate](https://docs.aws.amazon.com/elasticbeanstalk/latest/dg/configuring-https-ssl.html)

[Adding ebextensions to a war](https://stackoverflow.com/questions/18423932/where-to-add-ebextensions-in-a-war)

[Using the Https config file with beanstalk in a java application](https://github.com/aws-samples/eb-tomcat-snakes/blob/master/src/.ebextensions/inactive/HTTPS.md)

[Logging](https://medium.com/vividcode/logging-practice-for-elastic-beanstalk-java-apps-308ed7c4d63f)

[Maven profiles](https://ucsb-cs156.github.io/topics/maven_profiles/)
