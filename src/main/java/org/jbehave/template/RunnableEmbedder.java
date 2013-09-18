package org.jbehave.template;

import org.jbehave.core.InjectableEmbedder;
import org.jbehave.core.annotations.Configure;
import org.jbehave.core.annotations.UsingEmbedder;
import org.jbehave.core.annotations.UsingPaths;
import org.jbehave.core.configuration.AnnotationBuilder;

/**
 * Runnable Template Embedder.
 */
@Configure()
@UsingEmbedder(ignoreFailureInStories = true)
@UsingPaths(searchIn = "/**/*.story")
public class RunnableEmbedder extends InjectableEmbedder implements Runnable {
    private static final AnnotationBuilder builder = new AnnotationBuilder(RunnableEmbedder.class);

    @Override
    public void run() {
        injectedEmbedder().runStoriesAsPaths(builder.findPaths());
    }

    public static void main(String[] args) {
        RunnableEmbedder runnableEmbedder = new RunnableEmbedder();
        runnableEmbedder.useEmbedder(builder.buildEmbedder());
        runnableEmbedder.run();
    }

}
