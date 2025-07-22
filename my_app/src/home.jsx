import { Link } from 'react-router-dom';

export default function Home() {
    return (
        <div className="content">
        <div className="container my-5">
          <div className="text-center mb-4">
            <h2 className="fw-bold">📦 대시보드 Home</h2>
            <p className="text-muted">물류 현황을 빠르게 확인하고 이동하세요</p>
          </div>

          <div className="row g-4">
            <div className="col-md-4">
              <div className="card shadow dashboard-card">
                <div className="card-body text-center">
                  <div className="card-icon mb-2">
                    <i className="fas fa-boxes fa-2x"></i>
                  </div>
                  <div className="card-title">원재료 재고 관리</div>
                  <Link to="/ingredients/list" className="btn btn-primary mt-3">
                    이동하기
                  </Link>
                </div>
              </div>
            </div>

            <div className="col-md-4">
              <div className="card shadow dashboard-card">
                <div className="card-body text-center">
                  <div className="card-icon mb-2">
                    <i className="fas fa-truck-loading fa-2x"></i>
                  </div>
                  <div className="card-title">입고 처리</div>
                  <Link to="/inbound/list" className="btn btn-secondary mt-3">
                    이동하기
                  </Link>
                </div>
              </div>
            </div>

            <div className="col-md-4">
              <div className="card shadow dashboard-card">
                <div className="card-body text-center">
                  <div className="card-icon mb-2">
                    <i className="fas fa-dolly fa-2x"></i>
                  </div>
                  <div className="card-title">출고 처리</div>
                  <Link to="/outbound/list" className="btn btn-secondary mt-3">
                    이동하기
                  </Link>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    )
}