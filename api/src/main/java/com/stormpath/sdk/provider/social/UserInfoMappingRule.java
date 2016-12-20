package com.stormpath.sdk.provider.social;

import java.util.Set;

/**
 * A rule that indicates how a userInfo attribute from a Social Provider should populate one or more Stormpath Account field values.  By
 * creating rules, you configure which userInfo attribute values from the Social Provider should be copied to Stormpath Account field values.
 * <p>{@code UserInfoMappingRule}s are immutable.  If you want to change the mapping rules for Accounts in a
 * particular Social Directory, you must remove and add new {@code UserInfoMappingRule} instances to the
 * Directory Provider's {@link UserInfoMappingRules} instance.
 *
 * <h4>How does it work?</h4>
 * <p>Each {@code UserInfoMappingRule} has a {@code name} and a collection of Stormpath account
 * {@link #getAccountAttributes() attribute names}.</p>
 * <p>When a userInfo attribute from a Social Provider is encountered, every userInfo attribute from the Social Provider
 * with a matching name will have its value copied to the corresponding specified Stormpath account fields.</p>
 *
 * <h5>Example</h5>
 * <p>For example, assume that a mapping rule's {@code name} is {@code foo}, and the rule's
 * {@link #getAccountAttributes() accountAttributes} collection contains the Stormpath Account field names
 * of {@code givenName} and {@code surname}.</p>
 * <p>If a userInfo attribute named {@code foo} is encountered on login to have a value of {@code bar}, then
 * {@code bar} will automatically be copied to the specified Stormpath Account fields for that user.  This user would
 * then automatically have a {@code givenName} of {@code bar} and a {@code surname} of {@code bar}.</p>
 *
 * @since 1.3.0
 */
public interface UserInfoMappingRule {

    /**
     * Returns the UserInfo attribute name for a Social Provider, that when encountered, should have its value applied
     * as Account field values.
     * When this name is encountered when processing UserInfo from a Social Provider, its associated value will be set
     * as the value for all Stormpath Account field names specified in the
     * {@link #getAccountAttributes() accountAttributes} collection.
     *
     * @return UserInfo attribute name, that when encountered, should have its value set on the
     * {@link #getAccountAttributes() specified} Account fields.
     */
    String getName();

    /**
     * Returns the Stormpath account fields that should be updated when encountering {@link #getName() named}
     * UserInfo attribute name.  If discovered, that UserInfo attribute value will be set on all of the Stormpath account
     * fields named in this collection.
     *
     * @return the Stormpath account fields that should be updated when encountering {@link #getName() named}
     * UserInfo attribute name.
     */
    Set<String> getAccountAttributes();
}
