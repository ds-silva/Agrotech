function maxLenght(){
  var matr = document.querySelector('#matriculaUsuario')

  if(matr.length <= 6){
    matr.value = ''
    return
  }
}