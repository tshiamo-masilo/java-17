package com.security.java17.services;


import com.security.java17.model.UserId;

import java.security.Key;
import java.util.Optional;

/**
 * KeyStore service responsible for user key management.
 */
public interface KeyStoreService {

    /**
     * Get private key of CA.
     * @return
     */
    Key getCertificationAuthorityKey();

    /**
     * Create key for given user and store it in cache.
     * @param userId
     * @return
     */
    Key createUserKey(UserId userId);

    /**
     * Get user key from cache.
     * @param userId
     * @return
     */
    Optional<Key> getUserKey(UserId userId);

    /**
     * Remove user key from cache.
     * @param userId
     * @return
     */
    boolean removeUserKey(UserId userId);

}
