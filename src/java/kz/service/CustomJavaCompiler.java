/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kz.service;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import javax.lang.model.SourceVersion;
import javax.script.ScriptException;
import javax.tools.Diagnostic;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
/**
 *
 * @author Raiymbet
 */
public class CustomJavaCompiler {

    public static String javaCompile(String filepath) throws IOException, URISyntaxException, ScriptException {
        // TODO code application logic here
        String compile_result="";
        final JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
//        for(final SourceVersion version: compiler.getSourceVersions()){
//            System.out.println(version);
//        }
        
        final DiagnosticCollector< JavaFileObject > diagnostics = new DiagnosticCollector<>();
        //here code of java compiler
        try (final StandardJavaFileManager manager = 
                compiler.getStandardFileManager(diagnostics, null, null)) {
            final File file = new File(filepath);
            final Iterable<? extends JavaFileObject> sources = manager.getJavaFileObjectsFromFiles(Arrays.asList(file));
            final CompilationTask task = compiler.getTask(null, manager, diagnostics, null, null, sources);
            boolean task_result = task.call();
            if(!task_result){
                //here we provide test and get result of compile
                for(final Diagnostic<? extends JavaFileObject> diagnostic: diagnostics.getDiagnostics() ){
                    compile_result+=
                            diagnostic.getMessage(null)+" line "+
                            diagnostic.getLineNumber()+" in "+ 
                            diagnostic.getSource().getName();
                }
            }else{
                compile_result = "Task is called and compilation is completed!";
            }
        }
        return compile_result;
    }
    
}
