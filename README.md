maven-plugin
============

Maven integration with DependencyWatcher service.

### Usage ###

```xml
<plugin>
	<groupId>com.dependencywatcher</groupId>
	<artifactId>agent-maven-plugin</artifactId>
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
```

