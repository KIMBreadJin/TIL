import { axios } from 'axios'
import { useEffect, useState } from 'react'

const useAPI = (endpoint) => {
  const [data, setData] = useState([]) //state 를 빈 배열로 초기화
  // 컴포넌트 DOM에 mount(연결) 될 떄 data를 가져오기 위해
  useEffect(() => {
    console.log('useEffect 호출')
    getData()
  }, []) //두번째 매개변수가 빈 배열이면 COMPONENT 가 처음으로 랜더링 될 때 한번 호출됨

  const getData = async () => {
    console.log('getData 호출')
    const response = await axios.get(endpoint)
    console.log('axios를 통해 반환된 데이터 ', response.data)
    setData(response.data)
  }
  return data
}

export default useAPI
