package com.avinashcodes.beanscope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value= "prototype")
public class PrototypeClass {




}
