package com.security.java17.services;

import com.security.java17.model.JWToken;
import com.security.java17.model.LoginRequest;
import com.security.java17.model.UserData;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;


import java.util.Optional;

/**
 * Service controlling user access.
 */
public interface UserAccessService {

    /**
     * User login action, starts client session and issues JWT for client.
     * @param loginRequest username / password login request.
     * @return {@link UserData} containing roles and JWT.
     */
    Optional<UserData> login(LoginRequest loginRequest);

    /**
     * Verify if provided token has been issued properly and is correctly signed.
     * @param jwToken base64 encoded JWT/JWS token.
     * @return {@link Jws<Claims>} or empty if provided token is invalid.
     */
    Optional<Jws<Claims>> validate(JWToken jwToken);

    /**
     * Invalidate client session before JWT expires.
     * @param jwToken provided token is used to get user's identity and invalidate client's session.
     * @return true if login was ok, false otherwise.
     */
    boolean logout(JWToken jwToken);

}
