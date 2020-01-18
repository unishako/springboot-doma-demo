ALTER SYSTEM SET
 max_connections = '20';
ALTER SYSTEM SET
 shared_buffers = '512MB';
ALTER SYSTEM SET
 effective_cache_size = '1536MB';
ALTER SYSTEM SET
 maintenance_work_mem = '128MB';
ALTER SYSTEM SET
 checkpoint_completion_target = '0.7';
ALTER SYSTEM SET
 wal_buffers = '16MB';
ALTER SYSTEM SET
 default_statistics_target = '100';
ALTER SYSTEM SET
 random_page_cost = '1.1';
ALTER SYSTEM SET
 effective_io_concurrency = '200';
ALTER SYSTEM SET
 work_mem = '26214kB';
ALTER SYSTEM SET
 min_wal_size = '1GB';
ALTER SYSTEM SET
 max_wal_size = '2GB';
ALTER SYSTEM SET
 max_worker_processes = '2';
ALTER SYSTEM SET
 max_parallel_workers_per_gather = '1';
ALTER SYSTEM SET
 max_parallel_workers = '2';