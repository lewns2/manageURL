import { BrowserRouter, Routes, Route } from 'react-router-dom';

import { HomePage } from '../pages/home';
import { LoginPage, SignUpPage } from '../pages/user';
import {
  BoardCreatePage,
  BoardDetailPage,
  BoardHomePage,
  MyBoardPage,
  MyUrlPage,
} from '../pages/board';

export default function RouteHandler() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<HomePage />} />
        <Route path="/signup" element={<SignUpPage />} />
        <Route path="/login" element={<LoginPage />} />
        <Route path="/board" element={<BoardHomePage />} />
        <Route path="/board/write" element={<BoardCreatePage />} />
        <Route path="/myBoard" element={<MyBoardPage />} />
        <Route path="/myUrl" element={<MyUrlPage />} />
        <Route path="/board/:id" element={<BoardDetailPage />} />
      </Routes>
    </BrowserRouter>
  );
}
