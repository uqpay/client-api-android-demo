# UQPAY Android Client API Demo

Integrate this library to pay with Wallet App of UnionPay ( or Alipay, WechatPay... ). working with UQPAY Payments.

## Info
for this moment the the Client API SDK of Android is snapshot version. but the business logic is stable.
before the stable version will only update the support of payment method

## Testing it in your project

Set the maven snapshot repository (for the snapshot version we only upload to maven central snapshot repository )
```groovy
allprojects {
    repositories {
        maven {
            url 'https://oss.sonatype.org/content/repositories/snapshots/'
        }
    }
}
```

Add the dependency in your `build.gradle`:
```groovy
dependencies {
    implementation 'com.uqpay.sdk:client-api:1.0.0-SNAPSHOT'
}
```

## Usage

You can read the code on `MainActivity.kt` of this demo project

## Helps
* [Read the docs](https://developer.uqpay.com/api/#/)
* Find a bug or any feedback? [Open an issue](https://github.com/uqpaytechnology/client-api-android-demo/issues)