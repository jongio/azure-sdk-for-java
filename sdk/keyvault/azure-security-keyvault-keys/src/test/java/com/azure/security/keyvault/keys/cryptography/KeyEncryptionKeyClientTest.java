// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.security.keyvault.keys.cryptography;

import com.azure.core.cryptography.KeyEncryptionKey;
import com.azure.core.http.HttpPipeline;
import com.azure.core.http.rest.RestProxy;
import com.azure.core.util.Context;
import com.azure.security.keyvault.keys.models.JsonWebKey;
import com.azure.security.keyvault.keys.models.KeyOperation;
import com.azure.security.keyvault.keys.models.KeyVaultKey;
import org.junit.jupiter.api.Test;

import javax.crypto.spec.SecretKeySpec;
import java.util.Arrays;
import java.util.Base64;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class KeyEncryptionKeyClientTest extends KeyEncryptionKeyClientTestBase {

    private KeyEncryptionKey client;
    private HttpPipeline pipeline;
    private SecretKey secretKey;

    @Override
    protected void beforeTest() {
        beforeTestSetup();
        pipeline = getHttpPipeline();
    }

    private void setupSecretKeyAndClient(byte[] kek) {
        if (secretKey == null) {
            CryptographyServiceClient serviceClient = new CryptographyServiceClient(getEndpoint(), RestProxy.create(CryptographyService.class, pipeline));
            secretKey = serviceClient.setSecretKey(new SecretKey("secretKey", Base64.getEncoder().encodeToString(kek)), Context.NONE).block().getValue();
            client = new KeyEncryptionKeyClientBuilder()
                         .pipeline(pipeline)
                         .buildKeyEncryptionKey(secretKey.getId());
        }
    }

    @Test
    public void wrapUnwrapSymmetricAK128() {
        byte[] kek = { 0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08, 0x09, 0x0A, 0x0B, 0x0C, 0x0D, 0x0E, 0x0F };
        setupSecretKeyAndClient(kek);
        byte[] cek = { 0x00, 0x11, 0x22, 0x33, 0x44, 0x55, 0x66, 0x77, (byte) 0x88, (byte) 0x99, (byte) 0xAA, (byte) 0xBB, (byte) 0xCC, (byte) 0xDD, (byte) 0xEE, (byte) 0xFF };
        byte[] encrypted = client.wrapKey("A128KW", cek);
        byte[] ek = { 0x1F, (byte) 0xA6, (byte) 0x8B, 0x0A, (byte) 0x81, 0x12, (byte) 0xB4, 0x47, (byte) 0xAE, (byte) 0xF3, 0x4B, (byte) 0xD8, (byte) 0xFB, 0x5A, 0x7B, (byte) 0x82, (byte) 0x9D, 0x3E, (byte) 0x86, 0x23, 0x71, (byte) 0xD2, (byte) 0xCF, (byte) 0xE5 };
        assertArrayEquals(ek, encrypted);
        byte[] dek = client.unwrapKey("A128KW", ek);
        assertArrayEquals(dek, cek);
    }

    @Test
    public void wrapUnwrapLocalSymmetricAK128() {
        byte[] kek = { 0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08, 0x09, 0x0A, 0x0B, 0x0C, 0x0D, 0x0E, 0x0F };
        JsonWebKey localKey = JsonWebKey.fromAes(new SecretKeySpec(kek, "AES"),
            Arrays.asList(KeyOperation.WRAP_KEY, KeyOperation.UNWRAP_KEY));
        KeyVaultKey kvKey = KeyVaultKey.fromName("localSymmeticKey", localKey);
        KeyEncryptionKey keyEncryptionKey = new KeyEncryptionKeyClientBuilder()
            .pipeline(pipeline)
            .buildKeyEncryptionKey(kvKey);
        byte[] cek = { 0x00, 0x11, 0x22, 0x33, 0x44, 0x55, 0x66, 0x77, (byte) 0x88, (byte) 0x99, (byte) 0xAA, (byte) 0xBB, (byte) 0xCC, (byte) 0xDD, (byte) 0xEE, (byte) 0xFF };
        byte[] encrypted = keyEncryptionKey.wrapKey("A128KW", cek);
        byte[] ek = { 0x1F, (byte) 0xA6, (byte) 0x8B, 0x0A, (byte) 0x81, 0x12, (byte) 0xB4, 0x47, (byte) 0xAE, (byte) 0xF3, 0x4B, (byte) 0xD8, (byte) 0xFB, 0x5A, 0x7B, (byte) 0x82, (byte) 0x9D, 0x3E, (byte) 0x86, 0x23, 0x71, (byte) 0xD2, (byte) 0xCF, (byte) 0xE5 };
        assertArrayEquals(ek, encrypted);
        byte[] dek = keyEncryptionKey.unwrapKey("A128KW", ek);
        assertArrayEquals(dek, cek);
    }

    @Test
    public void wrapUnwrapSymmetricAK192() {
        byte[] kek = { 0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08, 0x09, 0x0A, 0x0B, 0x0C, 0x0D, 0x0E, 0x0F, 0x10, 0x11, 0x12, 0x13, 0x14, 0x15, 0x16, 0x17 };
        setupSecretKeyAndClient(kek);
        byte[] cek = { 0x00, 0x11, 0x22, 0x33, 0x44, 0x55, 0x66, 0x77, (byte) 0x88, (byte) 0x99, (byte) 0xAA, (byte) 0xBB, (byte) 0xCC, (byte) 0xDD, (byte) 0xEE, (byte) 0xFF };
        byte[] encrypted = client.wrapKey("A192KW", cek);
        byte[] ek = { (byte) 0x96, 0x77, (byte) 0x8B, 0x25, (byte) 0xAE, 0x6C, (byte) 0xA4, 0x35, (byte) 0xF9, 0x2B, 0x5B, (byte) 0x97, (byte) 0xC0, 0x50, (byte) 0xAE, (byte) 0xD2, 0x46, (byte) 0x8A, (byte) 0xB8, (byte) 0xA1, 0x7A, (byte) 0xD8, 0x4E, 0x5D };
        assertArrayEquals(ek, encrypted);
        byte[] dek = client.unwrapKey("A192KW", ek);
        assertArrayEquals(dek, cek);
    }

    @Test
    public void wrapUnwrapLocalSymmetricAK192() {
        byte[] kek = { 0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08, 0x09, 0x0A, 0x0B, 0x0C, 0x0D, 0x0E, 0x0F, 0x10, 0x11, 0x12, 0x13, 0x14, 0x15, 0x16, 0x17 };
        JsonWebKey localKey = JsonWebKey.fromAes(new SecretKeySpec(kek, "AES"),
            Arrays.asList(KeyOperation.WRAP_KEY, KeyOperation.UNWRAP_KEY));
        KeyVaultKey kvKey = KeyVaultKey.fromName("localSymmeticKey", localKey);
        client = new KeyEncryptionKeyClientBuilder()
                     .pipeline(pipeline)
                     .buildKeyEncryptionKey(kvKey);
        byte[] cek = { 0x00, 0x11, 0x22, 0x33, 0x44, 0x55, 0x66, 0x77, (byte) 0x88, (byte) 0x99, (byte) 0xAA, (byte) 0xBB, (byte) 0xCC, (byte) 0xDD, (byte) 0xEE, (byte) 0xFF };
        byte[] encrypted = client.wrapKey("A192KW", cek);
        byte[] ek = { (byte) 0x96, 0x77, (byte) 0x8B, 0x25, (byte) 0xAE, 0x6C, (byte) 0xA4, 0x35, (byte) 0xF9, 0x2B, 0x5B, (byte) 0x97, (byte) 0xC0, 0x50, (byte) 0xAE, (byte) 0xD2, 0x46, (byte) 0x8A, (byte) 0xB8, (byte) 0xA1, 0x7A, (byte) 0xD8, 0x4E, 0x5D };
        assertArrayEquals(ek, encrypted);
        byte[] dek = client.unwrapKey("A192KW", ek);
        assertArrayEquals(dek, cek);
    }
}
