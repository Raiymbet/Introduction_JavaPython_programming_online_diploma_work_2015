/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kz.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 * @author Raiymbet
 */
public class JavaRunner {
   
    public static String printLines(String name, InputStream ins) throws Exception {
        String line = null;
        String result = "";
        BufferedReader in = new BufferedReader(
            new InputStreamReader(ins));
        while ((line = in.readLine()) != null) {
            result += name + " " + line + "\n";
        }
        return result;
    }

    public static String runProcess(String command, String path) throws Exception {
        
        Process pro = Runtime.getRuntime().exec(command, null, new File(path));
        
        String run_result = "";
        run_result += printLines(command + " stdout:", pro.getInputStream());
        run_result += printLines(command + " stderr:", pro.getErrorStream());
        pro.waitFor();
        run_result += command + " exitValue() " + pro.exitValue();
        return run_result;
    }
}
