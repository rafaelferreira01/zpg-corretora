/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.jsf.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author suporte
 */
public class Utils {
    public static String md5(String valor) throws NoSuchAlgorithmException{
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(valor.getBytes());
        byte[] c = md.digest();
        return DatatypeConverter.printHexBinary(c).toLowerCase();
    }
    
}
