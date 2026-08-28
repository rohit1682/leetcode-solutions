char* newWord(const char* word) {
    int len = strlen(word);
    char* newWord = (char*)malloc(2 * len + 1); 
    for (int i = 0; i < len; i++) {
        newWord[i] = word[i];
    }
    for (int i = 0; i < len; i++) {
        newWord[len + i] = word[i] + 1;
    }
    newWord[2 * len] = '\0'; 
    return newWord;
}

char kthCharacter(int k) {
    char* word = (char*)malloc(2);
    word[0] = 'a';
    word[1] = '\0';
    while (strlen(word) < k) {
        word = newWord(word);
    }
    return word[k-1];
}