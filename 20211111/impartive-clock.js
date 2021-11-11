const logClockTime = () => {
  //시간 문자열을 civilian으로 변경
  var time = getClockTime()
  //화면을 지우고 시간을 출력함
  console.clear()
  console.log(time)
}
const getClockTime = () => {
  //현재 시간을 구하기
  var date = new Date()
  // 시간을 serialize(객체화함)
  var time = {
    hours: date.getHours(),
    minutes: date.getMinutes(),
    seconds: date.getSeconds(),
    ampm: 'AM',
  }
  //civilian 시간으로 변경
  if (time.hours == 12) time.ampm = 'PM'
  else if (time.hours > 12) {
    time.ampm = 'PM'
    time.hours -= 12
  }
  //2자리 숫자를 만들기 위해 시간에 0을 추가함
  if (time.hours < 10) time.hours = '0' + time.hours
  if (time.minutes < 10) time.minutes = '0' + time.minutes
  if (time.seconds < 10) time.seconds = '0' + time.seconds

  return time.hours + ':' + time.minutes + ':' + time.seconds + ' ' + time.ampm
}

//매초마다 시간을 화면에 출력함
setInterval(logClockTime, 1000)
