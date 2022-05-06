package model.builder;

import java.lang.reflect.InvocationTargetException;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;

/**
 * Generic builder pattern yazıldı
 * @param <T>
 */
public class TasBuilder<T> {
    private T instance;
    private boolean ifCond = true; // default
    public TasBuilder(Class<T> clazz){
       try {
           instance = clazz.getDeclaredConstructor().newInstance();
       } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
           e.printStackTrace();
       } 
    }
    
    public TasBuilder<T> with(Consumer<T> setter){
       if(ifCond)
           setter.accept(instance);
       return this;
    }
    
    public T get(){
       return instance;
    }
    
    public static <T> TasBuilder<T> build(Class<T> clazz) {
       return new TasBuilder<>(clazz);
    }
    
    public TasBuilder<T> If(BooleanSupplier condition){
       this.ifCond = condition.getAsBoolean();
       return this;
    }
    
    public TasBuilder<T> endIf(){
        this.ifCond = true;
        return this;
    }
 }