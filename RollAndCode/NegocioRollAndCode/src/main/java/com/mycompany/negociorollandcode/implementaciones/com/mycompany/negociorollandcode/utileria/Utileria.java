/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.negociorollandcode.implementaciones.com.mycompany.negociorollandcode.utileria;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author 52644
 */
public class Utileria {

    private static final String ALGORITMO = "AES";
    private static final String MODO = "ECB";
    private static final String PADDING = "PKCS5Padding";
    private static final String TRANSFORMACION = ALGORITMO + "/" + MODO + "/" + PADDING;

    private static final byte[] CLAVE_SECRETA = "olaquetachendo12".getBytes(StandardCharsets.UTF_8); 

    public static String encriptar(String s) throws Exception {
        SecretKeySpec clave = new SecretKeySpec(CLAVE_SECRETA, ALGORITMO);
        Cipher cipher = Cipher.getInstance(TRANSFORMACION);
        cipher.init(Cipher.ENCRYPT_MODE, clave);
        byte[] bytesEncriptados = cipher.doFinal(s.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(bytesEncriptados);
    }

    public static String desencriptar(String s) throws Exception {
        SecretKeySpec clave = new SecretKeySpec(CLAVE_SECRETA, ALGORITMO);
        Cipher cipher = Cipher.getInstance(TRANSFORMACION);
        cipher.init(Cipher.DECRYPT_MODE, clave);
        byte[] bytesDecodificados = Base64.getDecoder().decode(s);
        byte[] bytesDesencriptados = cipher.doFinal(bytesDecodificados);
        return new String(bytesDesencriptados, StandardCharsets.UTF_8);
    }
    }
