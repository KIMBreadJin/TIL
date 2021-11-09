import React, { useEffect } from 'react'
import { useContext } from 'react'
import { TodosContext } from '../App'
import { Form, Table, Button } from 'react-bootstrap'
import { useState } from 'react'
import { v4 as uuidv4 } from 'uuid'
import axios from 'axios'
import useAPI from '../useAPI'

const TodoList = () => {
  //App.js로부터 state와 dispatch를 수신함
  const { state, dispatch } = useContext(TodosContext)
  const [todoText, setTodoText] = useState('')
  const [editMode, setEditMode] = useState(false)
  const [editTodo, setEditTodo] = useState(null)
  const buttonTitle = editMode ? 'Edit' : 'Add'
  const endpoint = 'http://localhos:3000/todos'
  const savedTodos = useAPI(endpoint)
  useEffect(() => {
    console.log('TodoList useEffect')
    dispatch({ type: 'get', payload: savedTodos })
  }, [savedTodos])
  // 두번째 매개변수의 값이 변경될 떄 마다 호출됨
  //editMode는 사용자가 편집(Edit)을 클릭하면 true 값으로 설정됨
  //editTodo는 수정될 (to be edited) 특정 todo객체를 추가함
  const handleSubmit = async (e) => {
    e.preventDefault()
    if (editMode) {
      await axios.patch(endpoint + editTodo.id, { text: todoText })
      dispatch({ type: 'edit', payload: { ...editTodo, text: todoText } })
      setEditMode(false)
      setEditTodo(null)
    } else {
      const newTodo = { id: uuidv4(), text: todoText }
      await axios.post(endpoint, newTodo)
      dispatch({ type: 'add', payload: newTodo })
    }
    setTodoText('')
  }
  return (
    <div>
      <Form onSubmit={handleSubmit}>
        <Form.Group controlId='formBasicEmail'>
          <Form.Control type='text' placeholder='할일을 입력하세요' onChange={(e) => setTodoText(e.target.value)} />
        </Form.Group>
        <Button variant='primary' type='submit'>
          {buttonTitle}
        </Button>
      </Form>
      <Table striped bordered hover>
        <thead>
          <tr>
            <th>할일</th>
            <th>편집</th>
            <th>삭제</th>
          </tr>
        </thead>
        <tbody>
          {state.todos.map((todo) => (
            <tr key={todo.id}>
              <td>{todo.text}</td>
              <td
                onClick={() => {
                  setTodoText(todo.text)
                  setEditMode(true)
                  setEditTodo(todo)
                }}
              >
                <Button variant='link'>편집</Button>
              </td>
              <td
                onClick={async () => {
                  await axios.delete(endpoint + todo.id)
                  dispatch({ type: 'delete', payload: todo })
                }}
              >
                <Button variant='link'>삭제</Button>
              </td>
            </tr>
          ))}
        </tbody>
      </Table>
    </div>
  )
}

export default TodoList
