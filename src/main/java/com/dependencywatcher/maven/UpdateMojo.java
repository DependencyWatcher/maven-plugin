package com.dependencywatcher.maven;

import java.io.File;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

import com.dependencywatcher.client.DependencyWatcherClient;
import com.dependencywatcher.collector.ProjectInfoCollector;

@Mojo(name = "update")
public class UpdateMojo extends AbstractMojo {

	@Parameter(defaultValue = "${project}", readonly = true, required = true)
	private MavenProject project;

	@Parameter(required = true, readonly = true)
	private String apiKey;

	@Override
	public void execute() throws MojoExecutionException {
		getLog().info("Gathering information about project dependencies");

		ProjectInfoCollector projectCollector = new ProjectInfoCollector();
		try {
			File archive = projectCollector.collect(project.getBasedir()
					.toPath());
			try {
				DependencyWatcherClient client = new DependencyWatcherClient(
						apiKey);
				getLog().info("Updating project info on dependecywatcher.com");

				client.uploadRepository(
						project.getGroupId() + ":" + project.getArtifactId(),
						archive);
			} finally {
				if (!archive.delete()) {
					getLog().warn(
							"Unable to delete file: "
									+ archive.getAbsolutePath());
				}
			}
		} catch (Exception e) {
			throw new MojoExecutionException("Error running plug-in", e);
		}
	}
}
