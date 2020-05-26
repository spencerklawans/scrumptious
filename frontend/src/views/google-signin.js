/**
@license
Copyright 2014 Google Inc

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    https://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/
import '@polymer/polymer/polymer-legacy.js';

import './google-signin-aware.js';
import '@polymer/iron-icon/iron-icon.js';
import '@polymer/font-roboto/roboto.js';
import '@google-web-components/google-apis/google-js-api.js';
import '@polymer/paper-ripple/paper-ripple.js';
import '@polymer/paper-material/paper-material.js';
import '@polymer/iron-flex-layout/iron-flex-layout-classes.js';
import './google-icons.js';
import './google-signin-styles.js';
import { Polymer } from '@polymer/polymer/lib/legacy/polymer-fn.js';
import { html } from '@polymer/polymer/lib/utils/html-tag.js';
import "firebase/auth";
import firebase from 'firebase';

//import firebase from "firebase/app";
//import "firebase/auth";
//import "firebase/firestore";

/**
 * Enum brand values.
 * @readonly
 * @enum {string}
 */
 


var BrandValue = {
    GOOGLE: 'google',
    PLUS: 'google-plus'
};

const firebaseConfig = {
    apiKey: "AIzaSyDJ-EzfOs_m-ddUF480fGbDEWAMZmsnVyw",
    authDomain: "csc308-309.firebaseapp.com",
    databaseURL: "https://csc308-309.firebaseio.com",
    projectId: "csc308-309",
    storageBucket: "csc308-309.appspot.com",
    messagingSenderId: "5379470553",
    appId: "1:5379470553:web:c4c9166d26e72536ea7ac8",
    measurementId: "G-3DXXJ0MDKQ"
 };
 
require('firebase/auth')
 
firebase.initializeApp(firebaseConfig);
var provider = new firebase.auth.GoogleAuthProvider();

var auth = firebase.auth();


/**
 * Enum height values.
 * @readonly
 * @enum {string}
 */
var HeightValue = {
  SHORT: 'short',
  STANDARD: 'standard',
  TALL: 'tall'
};

/**
 * Enum button label default values.
 * @readonly
 * @enum {string}
 */
var LabelValue = {
  STANDARD: 'Sign in',
  WIDE: 'Sign in with Google',
  WIDE_PLUS: 'Sign in with Google+'
};

/**
 * Enum theme values.
 * @readonly
 * @enum {string}
 */
var ThemeValue = {
  LIGHT: 'light',
  DARK: 'dark'
};

/**
 * Enum width values.
 * @readonly
 * @enum {string}
 */
var WidthValue = {
  ICON_ONLY: 'iconOnly',
  STANDARD: 'standard',
  WIDE: 'wide'
};

/**
&lt;google-signin&gt; is used to authenticate with Google, allowing you to interact
with other Google APIs such as Drive and Google+.

<img style="max-width:100%;" src="https://cloud.githubusercontent.com/assets/107076/6791176/5c868822-d16a-11e4-918c-ec9b84a2db45.png"/>

If you do not need to show the button, use companion `<google-signin-aware>` element to declare scopes, check authentication state.

#### Examples

    <google-signin client-id="..." scopes="https://www.googleapis.com/auth/drive"></google-signin>

    <google-signin label-signin="Sign-in" client-id="..." scopes="https://www.googleapis.com/auth/drive"></google-signin>

    <google-signin theme="dark" width="iconOnly" client-id="..." scopes="https://www.googleapis.com/auth/drive"></google-signin>


#### Notes

The attribute `clientId` is provided in your Google Developers Console
(https://console.developers.google.com).

The `scopes` attribute allows you to specify which scope permissions are required
(e.g do you want to allow interaction with the Google Drive API). Many APIs also
need to be enabled in the Google Developers Console before you can use them.

The `requestVisibleActions` attribute is necessary if you want to write app
activities (https://developers.google.com/+/web/app-activities/) on behalf of
the user. Please note that this attribute is only valid in combination with the
plus.login scope (https://www.googleapis.com/auth/plus.login).

The `offline` attribute allows you to get an auth code which your server can
redeem for an offline access token
(https://developers.google.com/identity/sign-in/web/server-side-flow).
You can also set `offline-always-prompt` instead of `offline` to ensure that your app
will re-prompt the user for offline access and generate a working `refresh_token`
even if they have already granted offline access to your app in the past.

Use label properties to customize prompts.

The button can be styled in using the `height`, `width`, and `theme` attributes.
These attributes help you follow the Google+ Sign-In button branding guidelines
(https://developers.google.com/+/branding-guidelines).

The `google-signin-success` event is triggered when a user successfully authenticates
and `google-signed-out` is triggered when user signs out.
You can also use `isAuthorized` attribute to observe user's authentication state.

Additional events, such as `google-signout-attempted` are
triggered when the user attempts to sign-out and successfully signs out.

When requesting offline access, the `google-signin-offline-success` event is
triggered when the user successfully consents with offline support.

The `google-signin-necessary` event is fired when scopes requested via
google-signin-aware elements require additional user permissions.

#### Testing

By default, the demo accompanying this element is setup to work on localhost with
port 8080. That said, you *should* update the `clientId` to your own one for
any apps you're building. See the Google Developers Console
(https://console.developers.google.com) for more info.

@demo
*/

Polymer({
  /** @override */
  _template: html`
  	<!-- Firebase App (the core Firebase SDK) is always required and must be listed first -->
  	<script src="https://www.gstatic.com/firebasejs/6.1.1/firebase-app.js"></script>

  	<!-- Add Firebase products that you want to use -->
  	<script src="https://www.gstatic.com/firebasejs/6.1.1/firebase-auth.js"></script>

  	<script src="https://www.gstatic.com/firebasejs/6.1.1/firebase-database.js"></script>
    <style include="google-signin-styles iron-positioning"></style>
  	
    <google-signin-aware
      id="aware"
      app-package-name="{{appPackageName}}"
      client-id="{{clientId}}"
      cookie-policy="{{cookiePolicy}}"
      request-visible-actions="{{requestVisibsleActions}}"
      hosted-domain="{{hostedDomain}}"
      offline="{{offline}}"
      offline-always-prompt="{{offlineAlwaysPrompt}}"
      scopes="{{scopes}}"
      openid-prompt="{{openidPrompt}}"
      initialized="{{initialized}}"
      signed-in="{{signedIn}}"
      is-authorized="{{isAuthorized}}"
      need-additional-auth="{{needAdditionalAuth}}"
      has-plus-scopes="{{hasPlusScopes}}">
    </google-signin-aware>
    <template is="dom-if" if="{{raised}}">
      <paper-material id="shadow" class="fit" elevation="2" animated=""></paper-material>
    </template>
    <div id="button" class\$="[[_computeButtonClass(height, width, theme, signedIn, _brand, needAdditionalAuth)]]">

      <paper-ripple id="ripple" class="fit"></paper-ripple>
      <!-- this div is needed to position the ripple behind text content -->
      <div>
        <template is="dom-if" if="{{_computeButtonIsSignIn(signedIn, needAdditionalAuth)}}">
          <div class="button-content signIn" tabindex="0" on-click="signIn" on-keydown="_signInKeyPress">
            <span class="icon"><iron-icon icon="[[_brandIcon]]"></iron-icon></span>
            <span class="buttonText">{{_labelSignin}}</span>
          </div>
        </template>
        <template is="dom-if" if="{{_computeButtonIsSignOut(signedIn, needAdditionalAuth) }}">
          <div class="button-content signOut" tabindex="0" on-click="signOut" on-keydown="_signOutKeyPress">
            <span class="icon"><iron-icon icon="[[_brandIcon]]"></iron-icon></span>
            <span class="buttonText">{{labelSignout}}</span>
          </div>
        </template>
        <template is="dom-if" if="{{_computeButtonIsSignOutAddl(signedIn, needAdditionalAuth) }}">
          <div class="button-content signIn" tabindex="0" on-click="signIn" on-keydown="_signInKeyPress">
            <span class="icon"><iron-icon icon="[[_brandIcon]]"></iron-icon></span>
            <span class="buttonText">{{labelAdditional}}</span>
          </div>
        </template>
      </div>

    </div>
`,

  is: 'google-signin',

  /**
   * Fired when user is signed in.
   * You can use auth2 api to retrieve current user: `gapi.auth2.getAuthInstance()['currentUser'].get();`
   * @event google-signin-success
   */

  /**
   * Fired when the user is signed-out.
   * @event google-signed-out
   */

  /**
   * Fired if user requires additional authorization
   * @event google-signin-necessary
   */

  /**
   * Fired when signed in, and scope has been authorized
   * @param {Object} result Authorization result.
   * @event google-signin-aware-success
   */

  /**
   * Fired when there is an error during the signin flow.
   * @param {Object} detail The error object returned from the OAuth 2 flow.
   * @event google-signin-aware-error
   */

  /**
   * Fired when an offline authorization is successful.
   * @param {{code: string}} detail -
   *     code: The one-time authorization code from Google.
   *         Your application can exchange this for an `access_token` and `refresh_token`
   * @event google-signin-offline-success
   */

  /**
   * This block is needed so the previous @param is not assigned to the next property.
   */

  properties: {
    /**
     * App package name for android over-the-air installs.
     * See the relevant [docs](https://developers.google.com/+/web/signin/android-app-installs)
     */
    appPackageName: {
      type: String,
      value: ''
    },

    /**
     * The brand being used for logo and styling.
     *
     * @default 'google'
     */
    brand: {
      type: String,
      value: ''
    },

    /** @private */
    _brand: {
      type: String,
      computed: '_computeBrand(brand, hasPlusScopes)'
    },

    /**
     * a Google Developers clientId reference
     */
    clientId: {
      type: String,
      value: '5379470553-vten4rndcb1loc0m21fravtih0jl9gqn.apps.googleusercontent.com'
    },

    /**
     * The cookie policy defines what URIs have access to the session cookie
     * remembering the user's sign-in state.
     * See the relevant [docs](https://developers.google.com/+/web/signin/reference#determining_a_value_for_cookie_policy) for more information.
     *
     * @default 'single_host_origin'
     */
    cookiePolicy: {
      type: String,
      value: ''
    },

    /**
     * The height to use for the button.
     *
     * Available options: short, standard, tall.
     *
     * @type {string}
     */
    height: {
      type: String,
      value: 'tall'
    },

    /**
     * By default the ripple expands to fill the button. Set this to true to
     * constrain the ripple to a circle within the button.
     */
    fill: {
      type: Boolean,
      value: true
    },

    /**
     * An optional label for the button for additional permissions.
     */
    labelAdditional: {
      type: String,
      value: 'Additional permissions required'
    },

    /**
     * An optional label for the sign-in button.
     */
    labelSignin: {
      type: String,
      value: ''
    },

    _labelSignin: {
      type: String,
      computed: '_computeSigninLabel(labelSignin, width, _brand)'
    },

    /**
     * An optional label for the sign-out button.
     */
    labelSignout: {
      type: String,
      value: 'Sign out'
    },

    /**
     * If true, the button will be styled with a shadow.
     */
    raised: {
      type: Boolean,
      value: false
    },

    /**
     * The app activity types you want to write on behalf of the user
     * (e.g http://schemas.google.com/AddActivity)
     */
    requestVisibleActions: {
      type: String,
      value: ''
    },

    /**
     * The Google Apps domain to which users must belong to sign in.
     * See the relevant [docs](https://developers.google.com/identity/sign-in/web/reference) for more information.
     */
    hostedDomain: {
      type: String,
      value: ''
    },

    /**
     * Allows for offline `access_token` retrieval during the signin process.
     */
    offline: {
      type: Boolean,
      value: false
    },

    /**
     * Forces a re-prompt, even if the user has already granted offline
     * access to your application in the past. You only need one of
     * `offline` and `offlineAlwaysPrompt`.
     */
    offlineAlwaysPrompt: {
      type: Boolean,
      value: false
    },

    /**
     * The scopes to provide access to (e.g https://www.googleapis.com/auth/drive)
     * and should be space-delimited.
     */
    scopes: {
      type: String,
      value: ''
    },

    /**
     * Space-delimited, case-sensitive list of strings that
     * specifies whether the the user is prompted for reauthentication
     * and/or consent. The defined values are:
     *   none: do not display authentication or consent pages.
     *     This value is mutually exclusive with the rest.
     *   login: always prompt the user for reauthentication.
     *   consent: always show consent screen.
     *   select_account: always show account selection page.
     *     This enables a user who has multiple accounts to select amongst
     *     the multiple accounts that they might have current sessions for.
     * For more information, see "prompt" parameter description in
     * https://openid.net/specs/openid-connect-basic-1_0.html#RequestParameters
     */
    openidPrompt: {
      type: String,
      value: ''
    },

    /**
     * The theme to use for the button.
     *
     * Available options: light, dark.
     *
     * @type {string}
     * @default 'dark'
     */
    theme: {
      type: String,
      value: 'light'
    },

    /**
     * The width to use for the button.
     *
     * Available options: iconOnly, standard, wide.
     *
     * @type {string}
     */
    width: {
      type: String,
      value: 'wide'
    },

    _brandIcon: {
      type: String,
      computed: '_computeIcon(_brand)'
    },

    /**
     * True if *any* element has google+ scopes
     */
    hasPlusScopes: {
      type: Boolean,
      notify: true,
      value: false
    },

    /**
     * True if additional authorization required globally
     */
    needAdditionalAuth: {
      type: Boolean,
      notify: true,
      value: false
    },

    /**
     * True when the auth library has been initialized, and signedIn property value is set from the first api response.
     */
    initialized: {
      type: Boolean,
      notify: true,
      value: false
    },

    /**
     * Is user signed in?
     */
    signedIn: {
      type: Boolean,
      notify: true,
      value: false,
      observer: '_observeSignedIn'
    },

    /**
     * True if authorizations for *this* element have been granted
     */
    isAuthorized: {
      type: Boolean,
      notify: true,
      value: false
    }

  },

  _computeButtonClass: function(height, width, theme, signedIn, brand, needAdditionalAuth) {
    return "height-" + height + " width-" + width + " theme-" + theme + " signedIn-" + signedIn + " brand-" + brand + "  additionalAuth-" + needAdditionalAuth;
  },

  _computeIcon: function(brand) {
    return "google:" + brand;
  },

  /* Button state computed */
  _computeButtonIsSignIn: function(signedIn, additionalAuth) {
    return !signedIn;
  },

  _computeButtonIsSignOut: function(signedIn, additionalAuth) {
    return signedIn && !additionalAuth;
  },

  _computeButtonIsSignOutAddl: function(signedIn, additionalAuth) {
    return signedIn && additionalAuth;
  },

  _computeBrand: function(attrBrand, hasPlusScopes) {
    var newBrand;
    if (attrBrand) {
      newBrand = attrBrand;
    } else if (hasPlusScopes) {
      newBrand = BrandValue.PLUS;
    } else {
      newBrand = BrandValue.GOOGLE;
    };
    return newBrand;
  },

  _observeSignedIn: function(newVal, oldVal) {
    if (newVal) {
      if (this.needAdditionalAuth) {
        this.fire('google-signin-necessary');
      }
      this.fire('google-signin-success');
    }
    // Use `oldVal` avoids to fire the event at the initialization of
    // `signedIn`.
    else if (oldVal) {
      this.fire('google-signed-out');
    }
  },

  /**
   * Determines the proper label based on the attributes.
   */
  _computeSigninLabel: function(labelSignin, width, _brand) {
    if (labelSignin) {
      return labelSignin;
    } else {
      switch(width) {

        case WidthValue.WIDE:
          return (_brand == BrandValue.PLUS) ?
            LabelValue.WIDE_PLUS : LabelValue.WIDE;

        case WidthValue.STANDARD:
          return LabelValue.STANDARD;

        case WidthValue.ICON_ONLY:
          return '';

        default:
          console.warn("bad width value: ", width);
          return LabelValue.STANDARD;
      }
    }
  },

  /** Sign in user. Opens the authorization dialog for signing in.
   * The dialog will be blocked by a popup blocker unless called inside click handler.
   */
  signIn: function () {
	  //this.$.aware.signIn();
	  firebase.auth().signInWithPopup(provider).then(function(result) {
		  // This gives you a Google Access Token. You can use it to access the Google API.
		  var token = result.credential.accessToken;
		  // The signed-in user info.
		  var user = result.user;
		  // ...
	  })
  	}
});

//  _signInKeyPress: function (e) {
//    if (e.which == 13 || e.keyCode == 13 || e.which == 32 || e.keyCode == 32) {
//      e.preventDefault();
//      this.signIn();
//    }
//  },
//
//  /** Sign out the user */
//  signOut: function () {
//    this.fire('google-signout-attempted');
//    this.$.aware.signOut();
//  },
//
//  _signOutKeyPress: function (e) {
//    if (e.which == 13 || e.keyCode == 13 || e.which == 32 || e.keyCode == 32) {
//      e.preventDefault();
//      this.signOut();
//    }
//  }
//});
