
import './App.css';
import Home from './post/Home';
import {Routes, Route } from 'react-router-dom';
import AddPostForm from './post/AddPostForm';
import EditPostForm from './post/EditPostForm';
import SinglePostPage from './post/SinglePostPage';
function App() {
  return (
    
      <Routes>
<Route path="/"x element={<Home/>} ></Route>
<Route path="/add"x element={<AddPostForm/>} ></Route>
<Route path="post/edit/:postId"x element={<EditPostForm />} />
<Route path="post/:postId" element={<SinglePostPage />} />
    </Routes>
  
    
  );
}

export default App;
