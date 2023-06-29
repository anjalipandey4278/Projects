import React from 'react';
import { store } from './app/store';
import ReactDOM from 'react-dom/client';
import './index.css';
import { Provider } from 'react-redux';
import App from './App';
import { fetchPosts } from './post/postsSlice';
import { BrowserRouter as Router , Routes, Route } from 'react-router-dom';

store.dispatch(fetchPosts());
const root = ReactDOM.createRoot(document.getElementById('root'));

root.render(
  <React.StrictMode>
    <Provider store={store}>
    <Router>
        <Routes>
          <Route path="/*" element={<App />} />
        </Routes>
      </Router>
    </Provider>
  </React.StrictMode>,

);



