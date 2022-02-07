package com.github.kongchen.swagger.docgen.mavenplugin;

import com.github.kongchen.swagger.docgen.AbstractDocumentSource;
import com.github.kongchen.swagger.docgen.reader.ArcelikReader;
import lambda.annotation.*;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugin.logging.Log;

import java.util.Set;

public class ArcelikMavenDocumentSource extends AbstractDocumentSource<ArcelikReader> {

    public ArcelikMavenDocumentSource(ApiSource apiSource, Log log, String encoding) throws MojoFailureException {
        super(log, apiSource, encoding);
    }

    @Override
    protected Set<Class<?>> getValidClasses() {
        Set<Class<?>> result = super.getValidClasses();
        result.addAll(apiSource.getValidClasses(ApiGateway.class));
        result.addAll(apiSource.getValidClasses(QueryParam.class));
        result.addAll(apiSource.getValidClasses(PathParam.class));
        result.addAll(apiSource.getValidClasses(FormParam.class));
        result.addAll(apiSource.getValidClasses(HeaderParam.class));
        result.addAll(apiSource.getValidClasses(GenerateApiDocs.class));
        result.addAll(apiSource.getValidClasses(QueryParam.class));
        return result;
    }

    @Override
    protected ArcelikReader createReader() {
        return new ArcelikReader(swagger, LOG);
    }
}
