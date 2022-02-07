package com.github.kongchen.swagger.docgen.mavenplugin;

import com.github.kongchen.swagger.docgen.AbstractDocumentSource;
import com.github.kongchen.swagger.docgen.reader.ArcelikReader;
import com.google.common.collect.Sets;
import lambda.annotation.ApiGateway;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugin.logging.Log;

import java.util.Set;

public class ArcelikMavenDocumentSource extends AbstractDocumentSource<ArcelikReader> {

    public ArcelikMavenDocumentSource(ApiSource apiSource, Log log, String encoding) throws MojoFailureException {
        super(log, apiSource, encoding);
    }

    @Override
    protected Set<Class<?>> getValidClasses() {
        return Sets.union(super.getValidClasses(),
                apiSource.getValidClasses(ApiGateway.class));
    }

    @Override
    protected ArcelikReader createReader() {
        return new ArcelikReader(swagger, LOG);
    }
}
