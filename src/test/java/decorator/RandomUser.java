package decorator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface RandomUser {

}

/**@Retention(RetentionPolicy.RUNTIME): Эта строка указывает уровень сохранения аннотации. RetentionPolicy.RUNTIME означает, что аннотация будет доступна
 * во время выполнения программы, что позволяет использовать рефлексию для анализа аннотаций во время выполнения.

 @Target(ElementType.PARAMETER): Эта строка указывает цель (место применения) аннотации. ElementType.PARAMETER означает,
 что аннотацию можно применять только к параметрам метода.

 public @interface RandomUser { }: Это определение самой аннотации. Здесь создается новая аннотация с именем RandomUser.
 В данном контексте аннотация предназначена для применения к параметрам метода.
 **/