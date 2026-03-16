#include &lt;stdio.h&gt;
#include &lt;ctype.h&gt;

int countDigits(char arr[], int size) {
    int count = 0;
    for(int i = 0; i &lt; size; i++) {
        if(arr[i] >= '0' && arr[i] <= '9') {
            count++;
        }
    }
    return count;
}

int main() {
    // Example usage
    char arr[] = {'a', '1', 'b', '2', '3', 'c', '4'};
    int size = sizeof(arr) / sizeof(arr[0]);
    int digitCount = countDigits(arr, size);
    printf("Number of digits: %d\n", digitCount);
    return 0;
}