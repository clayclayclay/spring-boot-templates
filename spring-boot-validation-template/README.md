# Spring Boot Validation Framework

> This is a simple template about data validation integrated with Spring Boot.



## Template Description

### Main Class

**Controller**

* ValidateController1
* ValidateController2
* ValidateController3
* ValidateController4

**Model**

* Book

**Validator**

* SpringCustomValidator
* JavaxCustomValidator

**Annotaion**

* LongDataType

#### Main Class Description:

**Controller**

* ValidateController1

  * Code Snippet

    * ```java
          @PostMapping("/book")
          public String createBook(@RequestBody @Valid Book book, BindingResult result)
          {
              if (result.hasErrors())
              {
                  return getAllFieldsError(result.getAllErrors());
              }
              return "success";
          }
      ```

  * Key Point: Put the annotation `@Valid` in a forward position for object `book` in the method's first parameter.

  * Description: Before the method is invoked, Spring framework will first invoke one validator to validate the data of `book`, then if any error about the data occurs, it will put the error result into the object `result`.

* ValidateController2

  * Code Snippet

    * ```java
          @Autowired
          private SpringCustomValidator customValidator;

          /**
           * >>>>>>the object 'errors' has held the object 'book' in its target field.
           *
           * @param book
           * @param bindingResult
           * @return
           */
      	@PostMapping("/book")
          public String createBook(@RequestBody Book book, BindingResult bindingResult)
          {
              //manually call validator
              customValidator.validate(book, bindingResult);
              if (bindingResult.hasErrors())
              {
                  List<ObjectError> objectErrors = bindingResult.getAllErrors();
                  StringBuffer stringBuffer = new StringBuffer();
                  for (ObjectError objectError : objectErrors)
                  {
                      stringBuffer.append(MessageUtil.getFieldErrorMessage(objectError.getObjectName(), objectError.getCode()));
                  }
                  return stringBuffer.toString();
              }
              return "success";
          }
      ```

    * Key Point: inject one custom validator `customValidator`, the validator is implemented interface `Validator(Package: org.springframework.validation)`, the detail description about it is in below.

    * Description: inject the custom validator, and call it with parameters, including `book`, `bindingResult` to do the validation manually.

* ValidateController3

  * Code Snipper

    * ```java
          @Autowired
          private SpringCustomValidator customValidator;

          /**
           * set the callback method for data validation
           * the scope: only in this controller
           * @param binder
           */
          @InitBinder
          protected void initBinder(WebDataBinder binder)
          {
              System.out.println("method 'initBinder' is called");
              binder.setValidator(customValidator);
          }

          @PostMapping("/book")
          public String createBook(@RequestBody @Valid Book book, BindingResult bindingResult)
          {
              if (bindingResult.hasErrors())
              {
                  List<ObjectError> objectErrors = bindingResult.getAllErrors();
                  StringBuffer stringBuffer = new StringBuffer();
                  for (ObjectError objectError : objectErrors)
                  {
                      stringBuffer.append(MessageUtil.getFieldErrorMessage(objectError.getObjectName(), objectError.getCode()));
                  }
                  return stringBuffer.toString();
              }
              return "success";
          } 
      ```

  * Key Point: Put the annotation `@InitBinder` over the method `initBinder` to bind the validator `customValidator`.

  * Description:By binding the validator `customValidator` to validate the data before the method `createBook` called.

* ValidateController4

  * Code Snippet:

    * ```java
          @PostMapping("/book")
          public String createBook(@RequestBody Book student)
          {
              ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
              Validator validator = vf.getValidator();
              Set<ConstraintViolation<Book>> set = validator.validate(student);
              if (!set.isEmpty())
              {
                  StringBuffer stringBuffer = new StringBuffer();
                  for (ConstraintViolation<Book> constraintViolation : set)
                  {
                      String message = constraintViolation.getMessage();
                      String errorMsgCode = message.substring(1, message.length() - 1);
                      stringBuffer.append(MessageUtil.getFieldErrorMessage(constraintViolation.getRootBean().getName(), errorMsgCode));
                  }
                  return stringBuffer.toString();
              }
              return "success";
          }
      ```

  * Key Point: creating one validator by `ValidatorFactory` (hibernate class) directly.

  * Description: the method directly create one validator by hibernate standard interface, no associated with spring validation(That's to say, if you want to validate data simply, you can just t do it by importing the hibernate validation package ).

**Model**

* Book

  * Code Snippet

    * ```java
          @NotNull(message = "{NotEmpty.book.id}")
          private String id;

          @NotNull(message = "{NotEmpty.book.name}")
          @Size(min = 1, max = 5, message = "{OverSize.book.name}")
          private String name;

          @NotNull(message = "{NotEmpty.book.price}")
          @LongDataType(message = "{LongDateType.book.price}")
          private String price;

          @NotNull(message = "{NotEmpty.book.isLatest}")
          @AssertTrue(message = "{AssertTrue.book.isLatest}")
          private Boolean isLatest;
      ```

  * Key Point: Put some validation annotation over the field,  the annotation `LongDataType` is customized by me. The message is multi-message key and the multi-message has been maintained in the file: `message_en.properties`, `message_zh.properties`

**Validator**

* SpringCustomValidator

  * Code Snippet

    * ```java
      public class SpringCustomValidator implements Validator
      {
      	/**
           * you can extend your logic here, such as field's length, check for data type and so on.
           *
           * @param target
           * @param errors
           */
          @Override
          public void validate(Object target, Errors errors)
          {
              /**
               * The Util Class: ValidationUtils just can validate 'isEmpty'
               */
      //        ValidationUtils.rejectIfEmpty(errors, "id", "NotEmpty.book.id");
      //        ValidationUtils.rejectIfEmpty(errors, "name", "NotEmpty.book.name");
      //        ValidationUtils.rejectIfEmpty(errors, "price", "NotEmpty.book.price");

              /**
               * hold the target instance to write custom validation logic
               */
              validateObject(target, errors);

          }
      }
      ```

  * Key Point: the class is implemented the interface `Validator`, following Spring standard.

  * Description: the validation logic is in the method `validate`. If want to use the validator, you can call it manually or call the `WebDataBinder`to bind the validator.

* JavaxCustomValidator

  * Code Snippet

    * ```java
      public class JavaxCustomValidator implements ConstraintValidator<LongDataType, Object>
      {

          @Override
          public void initialize(LongDataType longDataType)
          {

          }

          @Override
          public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext)
          {
              if (o == null)
              {
                  return false;
              }
              try
              {
                  Long.parseLong(o.toString());
                  return true;
              }
              catch (NumberFormatException e)
              {
                  return false;
              }
          }
      }
      ```

  * Key Point: the class is implemented the interface `ConstraintValidator`, following the JSR-303 standard.

  * Description: the validator is bound with annotation `LongDataType`, If the annotation `LongDataType` is used over any class or field, the validator will be called.

**Annotation**

* LongDataType

  * Code Snippet

    * ```java
      @Constraint(validatedBy = JavaxCustomValidator.class)
      @Target({ElementType.FIELD})
      @Retention(RetentionPolicy.RUNTIME)
      public @interface LongDataType
      {
          String message() default "";

          Class<?>[] groups() default {};

          Class<? extends Payload>[] payload() default {};
      }
      ```

  * Key Point: If validating failed, the validator will return the  `message` value.







