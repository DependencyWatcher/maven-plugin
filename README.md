maven-plugin
============

Maven integration with DependencyWatcher service.

[![Build Status](https://travis-ci.org/DependencyWatcher/maven-plugin.png)](https://travis-ci.org/DependencyWatcher/maven-plugin)

### Usage ###

```xml
<build>
	<plugins>
		<plugin>
			<groupId>com.dependencywatcher</groupId>
			<artifactId>dependencywatcher-maven-plugin</artifactId>
			<configuration>
				<apiKey>Your API key here</apiKey>
			</configuration>
			<executions>
				<execution>
					<phase>compile</phase>
					<goals>
						<goal>update</goal>
					</goals>
				</execution>
			</executions>
		</plugin>
	</plugins>
</build>
```

#### Optional configuration options ####

Name     | Description                   | Default value
-------- | ----------------------------- | -------------------------------------
baseUri  | URL of DependencyWatcher API. | https://dependencywatcher.com/api/v1

