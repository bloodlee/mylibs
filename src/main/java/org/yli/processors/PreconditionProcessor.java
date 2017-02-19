package org.yli.processors;

import org.yli.annotations.Precondition;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by yli on 2/18/2017.
 */
@SupportedAnnotationTypes("org.yli.annotations.Precondition")
@SupportedSourceVersion(SourceVersion.RELEASE_6)
public class PreconditionProcessor extends AbstractProcessor {

  private Filer filer;

  @Override
  public synchronized void init(ProcessingEnvironment processingEnv) {
    filer = processingEnv.getFiler();
  }

  @Override
  public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
    for (Element elem : roundEnv.getElementsAnnotatedWith(Precondition.class)) {
      if (elem.getKind() == ElementKind.METHOD) {
        final ExecutableElement method = ((ExecutableElement)elem);
        final List<? extends VariableElement> parameters = method.getParameters();

        Precondition precondition = elem.getAnnotation(Precondition.class);

        Set<String> argSet = new HashSet<String>(Arrays.asList(precondition.nonNullArgs()));

        for (VariableElement varElem : parameters) {
          String argName = varElem.getSimpleName().toString();
          if (!argSet.contains(argName)) {
            throw new IllegalArgumentException(String.format("%s is not defined in "));
          }
        }

        String methodName = elem.getSimpleName().toString();

        String aspectText =
            "public aspect Advise_" + methodName + " {\n" +
            "before(): execution(*";

      }
    }

    return false;
  }
}
