// 1: without promise
function getDataWithoutPromise() {
    var request = new XMLHttpRequest();
    request.open("GET", "https://jsonplaceholder.typicode.com/posts", true);
    request.onreadystatechange = function () {
      if (this.readyState == 4 && this.status == 200) {
        var response = this.responseText;
        var data = JSON.parse(response);
        return data;
      }
    };
    request.send();
  }
  
  // 2: with promise
  function getDataWithPromise() {
    return new Promise(function (resolve, reject) {
      var request = new XMLHttpRequest();
      request.open("GET", "https://jsonplaceholder.typicode.com/posts", true);
      request.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
          var response = this.responseText;
          var data = JSON.parse(response);
          resolve(data);
          console.log("reslove");
        }
      };
      request.send();
    });
  }
  