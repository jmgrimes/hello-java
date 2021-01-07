# Hello Java

Hello Java is a simple Dropwizard application that says hello to a REST 
API caller through the /hello-world resource.  It serves as an example 
of how to build out an application with the Dropwizard framework, create 
a Docker container for its deployment, and then automate the gitflow 
release cycle with Github, Github Actions, and Github Packages.

## Workflows

The workflows for the CI/CD pipeline are contained within the 
.github/workflows folder.  There are currently two of these workflows which 
handle building the application whenever a push occurs to the develop or 
master branches, as well as to any feature, release, hotfix, and support 
branches.  It also triggers the build based on the opening of a new 
pull request targeting the develop or master branch, or any release 
branch.  Finally, it triggers the build whenever a new tag with the prefix 
"v" is created.

When the build runs, images are published to the container registry for a 
subset of these triggers.  Master branch builds are published with the 
"latest" tag.  Develop branch builds are published with the "develop" tag.
Release branch builds are published with the "release-{version}" tag.  
Versioned tags are published using the tag name.

## Configuration

When running the application, it expects to find a yaml file at the 
/app/conf/application.yaml location.  The file must contain the following 
contents.

```yaml
template: Hello, %s! # The format for the hello message, must include a %s for the name substitution.
defaultName: Stranger # The name to use when a name is not specified in the "name" query parameter.
```

## Telemetry

This application uses the OpenTelemetry Java Instrumentation library to provide 
an out of the box experience for publishing traces and metrics via OTLP.  To 
enable this functionality, an OTLP collector is expected to be running on port 
55680 within the same pod in Kubernetes.  This can be overridden with the 
OTEL_OTLP_ENDPOINT environment variable to ship these traces and metrics to another 
location, or OTEL_EXPORTER environment variable can be set to "logging" to bypass 
the OTLP endpoint and log these traces directly to the console.

