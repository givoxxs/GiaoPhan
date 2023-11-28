
function writeLog() {
    var myString = ''
    for (var param of arguments) {
        myString += `${param} - `
    }
    console.log(myString)
}

writeLog('Log1','Log2','Log3',5,6,9,12) 