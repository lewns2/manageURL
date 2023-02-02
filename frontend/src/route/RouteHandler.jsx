import { BrowserRouter, Routes, Route } from 'react-router-dom';

import Home from '../pages/home/HomePage';
import Login from '../pages/user/LoginPage';
import SignUp from '../pages/user/SignUpPage';

export default function RouteHandler() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/signup" element={<SignUp />} />
        <Route path="/login" element={<Login />} />
      </Routes>
    </BrowserRouter>
  );
}
