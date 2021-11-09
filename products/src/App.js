import './App.css'
import { useReducer } from 'react'
import React from 'react'
import TodoList from './components/TodoList'

const todosInitialState = {
  todos: [],
}
const todosReducer = (state, action) => {
  switch (action.type) {
    case 'get':
      return { ...state, todos: action.payload }
    case 'add':
      //const newToDo = { id: uuidv4(), text: action.payload } //배열에 새로운 할일 추가
      const addedToDos = [...state.todos, action.payload] // react에서는 기존 배열에 추가하기 위해 push를 사용하지 않고
      // 새로운 값을 추가하기 위해 spread 연산자 (...) 을 사용한다.
      return { ...state, todos: addedToDos } //기존의 state(객체) 를 spread하고 사로운 데이터 추가
    case 'delete':
      const filteredTodoState = state.todos.filter((todo) => todo.id !== action.payload.id)
      return { ...state, todos: filteredTodoState }
    case 'edit':
      const updatedToDo = { ...action.payload }
      const updatedToDoIndex = state.todos.findIndex((t) => t.id === action.payload.id)
      const updatedToDos = [...state.todos.slice(0, updatedToDoIndex), updatedToDo, ...state.todos.slice(updatedToDoIndex + 1)]
      return { ...state, toodos: updatedToDos }
    default:
      return todosInitialState
  }
}
export const TodosContext = React.createContext()
function App() {
  const [state, dispatch] = useReducer(todosReducer, todosInitialState)
  return (
    <>
      <TodosContext.Provider value={{ state, dispatch }}>
        <TodoList />
      </TodosContext.Provider>
    </>
  )
}

export default App
