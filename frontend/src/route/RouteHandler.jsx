import { BrowserRouter, Routes, Route } from 'react-router-dom';

import Start from '../pages/start/Start';
import Login from '../pages/user/Login';
import SignUp from '../pages/user/SignUp';

export default function RouteHandler() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Start />} />
        <Route path="/signup" element={<SignUp />} />
        <Route path="/login" element={<Login />} />
      </Routes>
    </BrowserRouter>
  );
}
