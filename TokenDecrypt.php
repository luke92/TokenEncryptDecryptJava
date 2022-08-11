<?php
 
function encrypt_decrypt($action, $string) {
    $output = false;
 
    $encrypt_method = "AES-128-ECB";
    $key = 'This is my secret';
 
    if ( $action == 'encrypt' ) {
        $output = openssl_encrypt($string, $encrypt_method, $key);
        $output;
    } else if( $action == 'decrypt' ) {
        $output = openssl_decrypt($string, $encrypt_method, $key);
    }
 
    return $output;
}
 
$plain_txt = "This is my plain text";
echo "Plain Text =" .$plain_txt. "\n";
 
$encrypted_txt = encrypt_decrypt('encrypt', $plain_txt);
echo "Encrypted Text = " .$encrypted_txt. "\n";
 
$decrypted_txt = encrypt_decrypt('decrypt', $encrypted_txt);
echo "Decrypted Text =" .$decrypted_txt. "\n";
 
if ( $plain_txt === $decrypted_txt ) echo "SUCCESS";
else echo "FAILED";
 
echo "\n";
 
?>