var mychar;
mychar="javascript";//var声明变量

function rec1(){
  alert("You click it!");
}
function rec2(){
  var message=confirm("YES or NO");
  if(message==true)
  {
    document.write("YES");
  }
  else
  {
    document.write("NO");
  }
}
function rec3(){
  var score;
  score=prompt("Input your score:");
  if(score>=90)
  {
    alert("excellent!");
  }
  else{
    alert("badddd...");
  }
}
function WindowOpen(){
  window.open('http://www.imooc.com','_blank','width=200,height=200,menubar=no,toolbar=no,status=no,scrollbar=yes');
  //mywin.close(); //关闭该窗口，阻止窗口弹出
}

