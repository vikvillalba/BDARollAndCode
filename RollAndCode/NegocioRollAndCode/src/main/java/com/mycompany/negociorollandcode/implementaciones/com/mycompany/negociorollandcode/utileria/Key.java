package com.mycompany.negociorollandcode.implementaciones.com.mycompany.negociorollandcode.utileria;

import java.util.Base64;

/**
 *
 * @author 52644
 */
public class Key {

    private static Key instance;
    private final byte[] secretKey; 

  
    private Key() throws Exception {
        this.secretKey = Utileria.generateKey(); 
    }


    public static Key getInstance() throws Exception {
        if (instance == null) {
            instance = new Key();
        }
        return instance;
    }


    public String getKeyBase64() {
        return Base64.getEncoder().encodeToString(secretKey);
    }

    public byte[] getKeyBytes() {
        return secretKey.clone();
    }
    
    
}
